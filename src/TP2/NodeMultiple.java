package TP2;

    public class NodeMultiple {
    public static final int ERROR_STATUS_INDEX_OUT_OF_RANGE = -1;
    public static final String ERROR_MSG_INDEX_OUT_OF_RANGE = "Index out of range";
    public final int NODE_MAX_ARITY = 10;
    protected String id;
   protected Object data;
   protected NodeMultiple[] daughters;

    /* Overridden methods */
    @Override
    public String toString() {
        return data.toString();
    }

    /* Getters/Setters */
    /**
     * Gets the {@code i}th daughter node.
     *
     * Aborts if the given index {@code i} is out of range.
     *
     * @param i the index of the daughter node.
     * @return the {@code i}th daughter node, or {@code null} if it does not exist.
     */
    public NodeMultiple getDaughter(int i) {

        return daughters[i];
    }

    /**
     * Sets the {@code i}th daughter node to the input parameter {@code daughter}.
     * Should be used cautiously, since {@code i} may not be the first index
     * available (i.e. there may be lower indexes which do not refer to any
     * daughter).
     *
     * If a daughter node is already referred to at this index then it is erased
     * with {@code daughter}.
     *
     * Aborts if the index {@code i} is out of range.
     *
     * @param daughters the node to be linked as a daughter of {@code this} node.
     * @param i        the daughter node's index
     */
    public void setDaughter(NodeMultiple daughters, int i) {

        this.daughters[i] = daughters;

    }

    /**
     * @return all the daughters
     */
    public NodeMultiple[] getDaughters() {

        return daughters;
    }

    /**
     * @param daughters the daughters to set
     */
    public void setDaughters(NodeMultiple[] daughters) {

        this.daughters = daughters;
    }

    /**
     * Adds the given {@code daughter} node at the first available index.
     *
     * If the max number of daughters ({@link #NODE_MAX_ARITY}) is already reacheds
     * nothing happens (no abort).
     *
     * @param daughter
     */
    public void addDaughter(NodeMultiple daughter) {
        if (daughters.length < NODE_MAX_ARITY)
        for  (int i = 0; i< daughters.length ; ++ i)
            if (this.daughters[i] == null)
                this.daughters[i] = daughter;
    }

    /**
     * @return the content data
     */
    public Object getData() {
        return data;
    }

    /**
     * @param data
     */
    public void setData(Object data) {
        this.data = data;
    }

    /**
     * @return {@code true} if and only if this node has at least one non-null
     *         daughter node.
     */
    public boolean hasDaughters() {
            for  (int i = 0; i< daughters.length ; ++ i)
            { if (this.daughters[i] != null)
                    return true;}
            return false;


    }

    /* Constructors */
    /**
     * Default constructor.
     */
    public NodeMultiple() {
    }

    /**
     * Constructor. Sets the content data to {@code data} and creates an empty set
     * of daughters.
     *
     * @param data
     */
   public NodeMultiple(Object data) {

       this.data = data;

    }



}
