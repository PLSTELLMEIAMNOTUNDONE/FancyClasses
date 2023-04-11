public interface SegmentTree {
    public SegmentTreeNode build();
    public int query(int l,int r);
    public void push(int l,int r,int toChange);
}
