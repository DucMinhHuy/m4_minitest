package minhhuy.minitestweek1.repository;

import minhhuy.minitestweek1.moddel.AppSpendingManagement;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;
@Transactional
public class AppSpendingManagementRepository implements IAppSpendingManagementRepository{
    @PersistenceContext
    private EntityManager manager;
    @Override
    public List<AppSpendingManagement> findAll() {
        TypedQuery<AppSpendingManagement>query=manager.createQuery("SELECT c FROM minhhuy.minitestweek1.moddel.AppSpendingManagement c", AppSpendingManagement.class);
        return query.getResultList();
    }

    @Override
    public AppSpendingManagement findById(Long id) {
        TypedQuery<AppSpendingManagement> query=manager.createQuery("SELECT c FROM AppSpendingManagement c WHERE c.id=:id", AppSpendingManagement.class);
        query.setParameter("id",id);
                try{
                    return query.getSingleResult();
                }catch (NoResultException e){
                    return null;
                }
    }

    @Override
    public void save(AppSpendingManagement appSpendingManagement) {
        if(appSpendingManagement.getId()!=null){
            manager.merge(appSpendingManagement);
        }else {
            manager.persist(appSpendingManagement);
        }
    }

    @Override
    public void remove(Long id) {
        AppSpendingManagement appSpendingManagement=findById(id);
        if(appSpendingManagement!=null){
            manager.remove(appSpendingManagement);
        }
    }

    @Override
    public void update(Long id, AppSpendingManagement appSpendingManagement) {
       appSpendingManagement=findById(id);
       if(appSpendingManagement!=null){
           manager.merge(appSpendingManagement);
       }
    }

}
