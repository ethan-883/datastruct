package 二叉树;

public class _341_扁平化嵌套列表迭代器 {
	//普通构造器
	/*private Iterator<Integer> it;
    ArrayList<Integer> res = new ArrayList<>();
    public NestedIterator(List<NestedInteger> nestedList) {
        for (NestedInteger node : nestedList) {
            traverse(node, res);
        }
        
        this.it = res.iterator();
    }

    private void traverse(NestedInteger root, List<Integer> res) {
        if (root.isInteger()) {
            res.add(root.getInteger());
            return;
        }
        for (NestedInteger child : root.getList()) {
            traverse(child, res);
        }
    }

    @Override
    public Integer next() {
        return it.next();
    }

    @Override
    public boolean hasNext() {
        return it.hasNext();
    }*/
	//惰性构造器
	/*private LinkedList<NestedInteger> list;
    //惰性构造器
    public NestedIterator(List<NestedInteger> nestedList) {
        list = new LinkedList<>(nestedList);
    }

    @Override
    public Integer next() {
        //hasNext保证第一个元素是Integer
        return list.remove(0).getInteger();
    }

    @Override
    public boolean hasNext() {
        while (!list.isEmpty() && !list.get(0).isInteger()) {
            List<NestedInteger> first = list.remove(0).getList();
            for (int i = first.size() - 1; i >= 0; i--) {
                list.addFirst(first.get(i));
            }
        }
        return !list.isEmpty();
    }*/
	
}
