public class PrioritizedObject<T> implements Comparable<PrioritizedObject> {
    private static int nextOrder = 0;
    private int priority;
    private int arrivalOrder;
    private T element;

    public PrioritizedObject(T element, int priority) {
        this.element = element;
        this.priority = priority;
        arrivalOrder = nextOrder;
        nextOrder++;

    }

    public T getElement() {
        return element;
    }

    /**
     * Returns the priority value for this node.
     *
     * @return the integer priority for this node
     */
    public int getPriority() {
        return priority;
    }

    /**
     * Returns the arrival order for this node.
     *
     * @return the integer arrival order for this node
     */
    public int getArrivalOrder() {
        return arrivalOrder;
    }

    /**
     * Returns a string representation for this node.
     *
     */
    public String toString() {
        return (element + " " + priority + " " + arrivalOrder);
    }

    /**
     * Returns 1 if the this object has higher priority than the given object and -1
     * otherwise.
     *
     * @param obj the object to compare to this node
     * @return the result of the comparison of the given object and this one
     */
    public int compareTo(PrioritizedObject obj) {
        int result;
        if (priority > obj.getPriority())
            result = 1;
        else if (priority < obj.getPriority())
            result = -1;
        else if (arrivalOrder > obj.getArrivalOrder())
            result = 1;
        else
            result = -1;
        return result;
    }
}
