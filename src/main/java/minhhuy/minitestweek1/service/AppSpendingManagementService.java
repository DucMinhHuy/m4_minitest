package minhhuy.minitestweek1.service;

import minhhuy.minitestweek1.moddel.AppSpendingManagement;
import minhhuy.minitestweek1.repository.IAppSpendingManagementRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class AppSpendingManagementService implements IAppSpendingManagementService{
    @Autowired
    private IAppSpendingManagementRepository IASMP;
    @Override
    public List<AppSpendingManagement> findAll() {
       return IASMP.findAll() ;
    }

    @Override
    public AppSpendingManagement findById(Long id) {
        return IASMP.findById(id);
    }

    @Override
    public void save(AppSpendingManagement appSpendingManagement) {
        IASMP.save(appSpendingManagement);
    }

    @Override
    public void remove(Long id) {
        IASMP.remove(id);
    }
    @Override
    public void update(Long id,AppSpendingManagement appSpendingManagement){
        IASMP.update(id,appSpendingManagement);
    }
}
