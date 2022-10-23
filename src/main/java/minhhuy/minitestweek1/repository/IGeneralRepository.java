package minhhuy.minitestweek1.repository;

import minhhuy.minitestweek1.moddel.AppSpendingManagement;

import java.util.List;

public interface IGeneralRepository<T> {
    List<T> findAll();

    T findById(Long id);

    void save(T t);

    void remove(Long id);
    void update(Long id, AppSpendingManagement appSpendingManagement);

}
