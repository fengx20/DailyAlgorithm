package datastructure.linked_list;

/**
 * @author: Fengx
 * @date: 2022-09-19
 * @description:
 **/
public interface List<E> {

    boolean add(E e);

    boolean addFirst(E e);

    boolean addLast(E e);

    boolean remove(Object o);

    E get(int index);

    void printLinkList();

}