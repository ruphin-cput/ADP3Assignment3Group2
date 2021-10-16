package za.ac.cput.service;

import java.util.Optional;
import java.util.OptionalInt;

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
