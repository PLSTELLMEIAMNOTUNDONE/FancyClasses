
public class SegmentTreeNode {
    int l;
    int r;
    int val;
    int div;
    SegmentTreeNode left=null;
    SegmentTreeNode right=null;
    SegmentTreeNode(int l,int r,int val){
        this.l=l;
        this.r=r;
        this.val=val;
        this.div=0;
    }
    SegmentTreeNode(int l,int r,int val,SegmentTreeNode left,SegmentTreeNode right){
        this.l=l;
        this.r=r;
        this.val=val;
        this.left=left;
        this.right=right;
        this.div=0;
    }
    void addDiv(int div){
        this.div+=div;
    }
    int retVal(){
        this.val+=this.div;
        left.div=this.div;
        right.div=this.div;
        this.div=0;
        return this.val;
    }
    public String toString(){
        return "["+l+","+r+"]"+" "+val+" ";
    }
}
