package minhhuy.minitestweek1.service;

import minhhuy.minitestweek1.moddel.AppSpendingManagement;

import java.util.List;

public interface IGeneralService<T> {
    List<T> findAll();

    T findById(Long id);

    void save(T t);

    void remove(Long id);
    void update(Long id, AppSpendingManagement appSpendingManagement);
}
