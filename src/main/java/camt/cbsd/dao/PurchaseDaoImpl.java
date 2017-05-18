package camt.cbsd.dao;

import camt.cbsd.entity.Purchase;
import camt.cbsd.repository.PurchaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by pariy on 5/18/2017.
 */
@Repository
public class PurchaseDaoImpl implements PurchaseDao{
    PurchaseRepository purchaseRepository;

    @Autowired
    public void setPurchaseRepository(PurchaseRepository purchaseRepository){
        this.purchaseRepository = purchaseRepository;
    }

    @Override
    public Purchase addPurchase(Purchase purchase) {
        return purchaseRepository.save(purchase);
    }
}
