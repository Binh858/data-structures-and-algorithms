public class BinarySearchTree {
         
    // Tu duoc luu tai nut hien tai;
       private String data;  
      
       //Tham chieu toi ben trai;
       private BinarySearchTree left;
      
      
       //Tham chieu toi cay con ben pahi( nut ben phai)
       //Nhanh cay ben phair chua tat ca cac tu lon hon this.data, theo thu tu tu dien;
       private BinarySearchTree right;
      
       //Ham tao cay( co the la cay con) voi this.data bang word;
       //Cac tham chieu left va right nhan gia tri mac dinh null;
       public BinarySearchTree(String word)
       {
           this.data = word;
           left = null;
           right = null;
       }
      
       //Ham chen mot tu vao cay hien tai, dung phuong phap de quy;
       public  void insert(String word)
       {
          //so sanh word voi this.data
          //neu word < data thi co nghia word can nam o cay con ben trai
           // neu khong thi word can nam o cay con ben phai.
           // goi phuong thuc insert() cua cay con thich hop (trai hoac phai)
           // hoac khoi tao cAy con trai/phai neu chua co
           //BinarySearchTree temp = new BinarySearchTree( word);

           if (  word.compareToIgnoreCase(data) < 0 )
           {
               /*
               if(left != null)
                   left.insert(word);
               else
                   left = new BinarySearchTree(word);*/
               if ( left == null)
                   left = new BinarySearchTree( word);
               else
                   left.insert(word);
           }
           else
           {
               /*
               if(right != null)
                   right.insert(word);
               else
                   right = new BinarySearchTree(word);*/
               if ( right == null)
                   right = new BinarySearchTree( word);
               else
                   right.insert(word);
           }
        }
     
       //dung de qui de duyet cay nhi phan, in ra theo thu tu tu nho den lon.
       public void printSortedList() {
         
           //Goi printSortedList() cua cay con trai( de in cac tu nho hon data)
           //IN data
           //Goi printStoredList() cua cay con phai( de in cac tu lon hon data)
           if ( left != null )
               left.printSortedList();
           System.out.print(data + " ");
           if (right != null)
               right.printSortedList();
       }
       public boolean search( String word)
       {
                   if ( word.compareToIgnoreCase( this.data ) == 0)
                       return true;
          
               //System.out.print( "RUN");
                   if ( ( word.compareToIgnoreCase( this.data) < 0))
                   {
                       //System.out.print("Nho");
                         if ( left != null)
                             return left.search(word);
                   }
                    else
                    {
                        //System.out.print("Lon");
                        if ( right != null)
                            return right.search(word);
                    }
                  
          return false;
       }
}
