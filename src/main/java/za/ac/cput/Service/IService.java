package za.ac.cput.Service;
/*  IService.java
    Service interface
    Author: Adriaan Burger(219014868)
    Date: 27 July 2021
 */
public interface IService <T, ID>{
    T create(T t);
    T read(ID id);
    T update(T t);
    boolean delete(ID id);
}
