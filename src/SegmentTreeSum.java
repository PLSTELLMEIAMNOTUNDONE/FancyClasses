import java.util.LinkedList;

public class SegmentTreeSum implements  SegmentTree{
    int[] a;
    SegmentTreeNode head;


    SegmentTreeSum(){
        a=new int[0];
    }
    SegmentTreeSum(int[] a){
        this.a=a;

    }
    public  SegmentTreeNode  build() {
        return buildSolv(0,a.length);
    }
    public  SegmentTreeNode  buildSolv(int lb,int rb) {
        if(lb==rb-1){
            return new SegmentTreeNode(lb,rb,a[lb]);
        }
        else{
            int mid=(lb+rb)/2;
            SegmentTreeNode l=buildSolv(lb,mid);
            SegmentTreeNode r=buildSolv(mid,rb);
            return new SegmentTreeNode(lb,rb,l.val+r.val,l,r);
        }

    }
    public int query(int l,int r){
        if(head==null)head=build();
        return querySolv(l,r,head);

    }
    int querySolv(int l,int r,SegmentTreeNode nd){
        if(nd.r<=r&&nd.l>=l){
            return nd.val;
        }
        if(Math.min(nd.r,r)<=Math.max(nd.l,l)){
            return 0;
        }
        return  querySolv(l,r,nd.left)+querySolv(l,r,nd.right);
    }
    public void push(int l,int r,int toChange){
        return;
    }
    public String toString(){
        if(head==null)return "";
        LinkedList<SegmentTreeNode> list  =new LinkedList<>();
        StringBuilder ans=new StringBuilder();
        list.push(head);
        int lvl=0;
        while(!list.isEmpty()){
            lvl++;
            ans.append(lvl+" ");
            int sz=list.size();
            for(int i=0;i<sz;i++){
                SegmentTreeNode nd=list.removeLast();
                ans.append(nd.toString());
                if(nd.left!=null)list.addFirst(nd.left);
                if(nd.right!=null)list.addFirst(nd.right);

            }
            ans.append("\n");
        }
        return ans.toString();
    }
}
