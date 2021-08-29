package za.ac.cput.repository;

// Add the @Deprecated tag after each person has done their DB Milestone task
public interface IRepository<T,ID>
{
    public T create(T t);
    public T read(ID id);
    public T update(T t);
    public boolean delete(ID id);
}
