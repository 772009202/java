package datastructure.linkedstore.single;

/**
 * Created by YuChen on 2018/3/26 0026
 *
 * <p>单向链表的节点定义
 */
public interface Node<T> {

  // 获取结点数据域
  public T getData();

  // 设置结点数据域
  public void setData(T t);
}
