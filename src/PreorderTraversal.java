import java.util.*;

public class PreorderTraversal {


    public boolean preorderTraversal(TreeNode root) {
        boolean answer = false;

        if(root == null){
            return false;
        }

        if(root.left == null ^ root.right == null){
            return false;
        }

        if(root.left == null && root.right == null){
            return true;
        }

        Queue<TreeNode> Q = new LinkedList<>();
        Q.add(root.left);
        Q.add(root.right);
        while(!Q.isEmpty()){
            TreeNode a = Q.remove();
            TreeNode b = Q.remove();
            if(a == null && b == null){
                continue;
            }
            if(a.val != b.val){
                answer = false;
                break;
            }

            boolean oneOfChildrenHaveNoPair =
                    (a.left == null ^ b.right == null) ||
                            (a.right == null ^ b.left == null);
            if(oneOfChildrenHaveNoPair){
                answer = false;
                break;
            }

            answer = true;

            Q.add(a.left);
            Q.add(b.right);
            Q.add(a.right);
            Q.add(b.left);
        }

        return answer;

    }

}
