package za.ac.cput.repository;
/*  IRepository.java
    Repository interface
    Author: Adriaan Burger(219014868)
    Date: 25 July 2021
 */
public interface IRepository <T, ID>{
    public T create(T t);
    public T read(ID id);
    public T update(T t);
    public boolean delete(ID id);
}
