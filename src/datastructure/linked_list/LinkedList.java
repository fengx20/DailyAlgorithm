package datastructure.linked_list;

/**
 * @author: Fengx
 * @date: 2022-09-19
 * @description: 实现链表
 **/
public class LinkedList<E> implements List<E> {

    /**
     * 被 transient 修饰的变量不能被序列化
     */
    /**
     * 链表长度
     */
    transient int size = 0;
    /**
     * 第一个节点
     */
    transient Node<E> first;
    /**
     * 最后一个节点
     */
    transient Node<E> last;

    /**
     * 构造方法
     */
    public LinkedList(){

    }

    /**
     * 添加节点（尾插法）
     * @param e
     * @return
     */
    @Override
    public boolean add(E e) {
        linkLast(e);
        return true;
    }

    /**
     * 添加节点（头插法）
     * @param e
     * @return
     */
    @Override
    public boolean addFirst(E e) {
        linkFirst(e);
        return true;
    }

    /**
     * 添加节点（尾插法）
     * @param e
     * @return
     */
    @Override
    public boolean addLast(E e) {
        linkLast(e);
        return true;
    }

    /**
     * 删除节点
     *
     * 删除元素的过程需要 for 循环判断比删除元素的值，找到对应的元素，进行删除。
     * 循环比对的过程是一个 O(n) 的操作，删除的过程是一个 O(1) 的操作。所以如果这个链表较大，删除的元素又都是贴近结尾，那么这个循环比对的过程也是比较耗时的。
     *
     * @param o
     * @return
     */
    @Override
    public boolean remove(Object o){
        if(o == null){
            for(Node<E> x = first; x != null; x = x.next){
                if(x.item == null){
                    unlink(x);
                    return true;
                }
            }
        }else{
            for(Node<E> x = first; x != null; x = x.next){
                if(o.equals(x.item)){
                    unlink(x);
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 根据下标获取节点
     * @param index
     * @return
     */
    @Override
    public E get(int index) {
        return node(index).item;
    }

    /**
     * 输出链表
     */
    @Override
    public void printLinkList() {
        if (this.size == 0) {
            System.out.println("链表为空");
        } else {
            Node<E> temp = first;
            System.out.print("目前的列表，头节点：" + first.item + " 尾节点：" + last.item + " 整体：");
            while (temp != null) {
                System.out.print(temp.item + "，");
                temp = temp.next;
            }
            System.out.println();
        }
    }

    /**
     * 头插节点
     *
     * 头插的操作流程，先把头节点记录下来。之后创建一个新的节点，新的节点构造函数的头节点入参为null，通过这样的方式构建出一个新的头节点。
     * 原来的头结点，设置 f.prev 连接到新的头节点，这样的就可以完成头插的操作了。另外如果原来就没有头节点，设置设置为新的节点即可。
     * 最后记录当前链表中节点的数量，也就是你使用 LinkedList 获取 size 时候就是从这个值获取的。
     * @param e
     */
    void linkFirst(E e){
        // 获取头结点
        final Node<E> f = first;
        // 创建新节点
        final Node<E> newNode = new Node<>(null, e, f);
        // 新节点成为第一个节点
        first = newNode;
        // 如果原来的第一个节点为空，则最后一个节点也是新节点，否则原来的第一个节点的前指针指向新节点
        if(f == null){
            last = newNode;
        }else{
            f.prev = newNode;
        }
        size++;
    }

    /**
     * 尾插节点
     *
     * 尾差节点与头插节点正好相反，通过记录当前的结尾节点，创建新的节点，并把当前的结尾节点，通过 l.next 关联到新创建的节点上。同时记录 size 节点数量值。
     * @param e
     */
    void linkLast(E e){
        final Node<E> l = last;
        final Node<E> newNode = new Node<>(l, e, null);
        last = newNode;
        if(l == null){
            first = newNode;
        }else{
            l.next = newNode;
        }
        size++;
    }

    /**
     * 拆链操作
     *
     * unlink 是一种拆链操作，只要你给定一个元素，它就可以把当前这个元素的上一个节点和一个节点进行相连，之后把自己拆除。
     * 这个方法常用于 remove 移除元素操作，因为整个操作过程不需要遍历，拆除元素后也不需要复制新的空间，所以时间复杂读为 O(1)
     *
     * @param x
     * @return
     */
    E unlink(Node<E> x){
        final E element = x.item;
        final Node<E> next = x.next;
        final Node<E> prev = x.prev;
        if(prev == null){
            first = next;
        }else{
            prev.next = next;
            x.prev = null;
        }
        if(next == null){
            last = prev;
        }else{
            next.prev = prev;
            x.next = null;
        }
        x.item = null;
        size--;
        return element;
    }

    /**
     * 返回对应下标节点
     * @param index
     * @return
     */
    Node<E> node(int index) {
        Node<E> x;
        if (index < (size >> 1)) {
            x = first;
            for (int i = 0; i < index; i++) {
                x = x.next;
            }
        } else {
            x = last;
            for (int i = size - 1; i > index; i--) {
                x = x.prev;
            }
        }
        return x;
    }

    /**
     * 链表节点
     *
     * 链表的数据结构核心根基就在于节点对象的使用，并在节点对象中关联当前节点的上一个和下一个节点。通过这样的方式构建出链表结构。
     * 但也因为在链表上添加每个元素的时候，都需要创建新的 Node 节点，所以这也是一部分耗时的操作。
     *
     * @param <E>
     */
    public static class Node<E>{
        // 元素
        E item;
        // 后指针
        Node<E> next;
        // 前指针
        Node<E> prev;

        public Node(Node<E> prev, E element, Node<E> next){
            this.item = element;
            this.next = next;
            this.prev = prev;
        }
    }


    /**
     * 测试
     * @param args
     */
    public static void main(String[] args) {
        List<String> list = new LinkedList<>();
        // 添加元素
        list.add("a");
        list.addFirst("b");
        list.addLast("c");
        // 打印列表
        list.printLinkList();
        // 头插元素
        list.addFirst("d");
        // 删除元素
        list.remove("b");
        // 打印列表
        list.printLinkList();
    }

}
