package com.java.domainstore.ThanhTri;

import com.java.domainstore.dao.TLDDAO;
import com.java.domainstore.dao.DomainDAO;
import com.java.domainstore.model.DomainModel;
import com.java.domainstore.model.DomainStatusEnum;
import com.java.domainstore.model.TLDModel;
import com.java.domainstore.ui.view.swing.fLogin;
import com.java.domainstore.ui.view.swing.fMain;
import com.java.domainstore.ui.view.swing.fRegister;
import java.util.ArrayList;
import java.util.List;

public class TestApp {

    public static void TLDDAOTest(int i) {
        switch (i) {
            case 1:
                int kq = TLDDAO.getInstance().insert(new TLDModel(8, ".dev", 30000));
                System.out.printf("Insert %d row(s)", kq);
                break;
            case 2:
                kq = TLDDAO.getInstance().update(new TLDModel(8, ".dev", 30000));
                System.out.printf("Update %d row(s)", kq);
                break;
            case 3:
                kq = TLDDAO.getInstance().delete(new TLDModel(8, ".dev", 30000));
                System.out.printf("Delete %d row(s)", kq);
                break;
            case 4:
                List<TLDModel> tlds = TLDDAO.getInstance().selectAll();
                for (TLDModel tld : tlds) {
                    System.out.printf("%02d. %10s - %d%n", tld.getId(), tld.getName(), tld.getPrice());
                }
                break;
            case 5:
                TLDModel tld = TLDDAO.getInstance().selectById(new TLDModel(1, "", 0));
                System.out.printf("%02d. %10s - %d%n", tld.getId(), tld.getName(), tld.getPrice());
                break;
        }
    }

    public static void DomainDAOTest(int i) {
        switch (i) {
            case 1:
                int kq = DomainDAO.getInstance().insert(new DomainModel(0, "helloworld", 1, DomainStatusEnum.AVAILABLE, 2));
                System.out.printf("Insert %d row", kq);
                break;
            case 2:
                kq = DomainDAO.getInstance().update(new DomainModel(0, "helloworld", 1, DomainStatusEnum.AVAILABLE, 2));
                System.out.printf("Insert %d row", kq);
                break;
            case 3:
                kq = DomainDAO.getInstance().delete(new DomainModel(9, "", 1, DomainStatusEnum.AVAILABLE, 2));
                System.out.printf("Insert %d row", kq);
                break;
            case 4:
                ArrayList<DomainModel> domains = DomainDAO.getInstance().selectAll();
                for (DomainModel domain : domains) {
                    System.out.println(domain);
                }
                break;
            case 5:
                DomainModel domain = DomainDAO.getInstance().selectById(new DomainModel(1, "", 1, DomainStatusEnum.AVAILABLE, 1));
                System.out.println(domain);
                break;
            case 6:
                domain = DomainDAO.getInstance().selectByName(new DomainModel(1, "website", 3, DomainStatusEnum.AVAILABLE, 1));
                System.out.println(domain);
                break;
        }
    }

    public static void UITest() {
                fLogin.start();
        //        fRegister.start();
//        fMain.start();
    }

    public static void main(String[] args) {
//        TLDDAOTest(5);
//        DomainDAOTest(6);
        UITest();
    }
}
