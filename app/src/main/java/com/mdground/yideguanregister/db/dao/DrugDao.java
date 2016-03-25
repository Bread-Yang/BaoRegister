package com.mdground.yideguanregister.db.dao;

import android.content.Context;

import com.mdground.yideguanregister.bean.Drug;

import java.util.List;

/**
 * 药物数据
 */
public class DrugDao extends GenericsDao<Drug> {

    private static DrugDao instance = null;

    protected DrugDao(Context context) {
        super(context);
    }

    public static DrugDao getInstance(Context context) {
        if (instance == null) {
            instance = new DrugDao(context);
        }

        return instance;
    }

    public void saveDrugs(List<Drug> drugs) {
        if (drugs == null) {
            return;
        }

        for (int i = 0; i < drugs.size(); i++) {
            List<Drug> ds = getDb().findAllByWhere(Drug.class, "DrugID = " + drugs.get(i).getDrugID());
            if (ds.size() > 0) {
                continue;
            }

            updateDrug(drugs.get(i));
        }
    }

    public void updateDrug(Drug drug) {
//        if (drug.getPhotoList() != null) {  // 讲array转为string
//            drug.setPhotoListString(new Gson().toJson(drug.getPhotoList()));
//        }

        Drug oldDrug = getDrugByDrugID(drug.getDrugID());
        if (oldDrug != null) {
            drug.setId(oldDrug.getId());
            if (drug.getProviderID() == 0 && oldDrug.getProviderID() != 0) {
                drug.setProviderID(oldDrug.getProviderID()); // providerID服务器没有返回,要在本地储存
            }

            getDb().update(drug);
        } else {
            getDb().save(drug);
        }
    }

    public Drug getDrugByDrugID(int drugID) {
        List<Drug> list = getDb().findAllByWhere(Drug.class, "DrugID = " + drugID);
        if (list != null && list.size() > 0) {
            Drug drug = list.get(0);
//            if (drug.getPhotoListString() != null) {
//                drug.setPhotoList((ArrayList)new Gson().fromJson(drug.getPhotoListString(), new TypeToken<ArrayList<DrugPhoto>>() {
//                }.getType()));
//            }
            return list.get(0);
        }
        return null;
    }

    public List<Drug> getDrugByDrugName(String drugName) {
        return getDb().findAllByWhere(Drug.class, "DrugName like '%" + drugName + "%'");
    }

    public List<Drug> getDrugByClinicID(int clinicID) {
        return getDb().findAllByWhere(Drug.class, "ClinicID = " + clinicID);
    }

    public List<Drug> getDrugByDrugNameAndClinicID(String drugName, int clinicID) {
        return getDb().findAllByWhere(Drug.class, "DrugName like '%" + drugName + "%' and ClinicID = " + clinicID);
    }

    public List<Drug> getDrugByClinicIDAndTypeIDSmallAndNotIncludeTypeID(int clinicID, int typeIDSmall, int typeID) {
        if (typeIDSmall != 0) {
            return getDb().findAllByWhere(Drug.class, "ClinicID = " + clinicID + " and TypeID <> " + typeID + " and TypeIDSmall = " + typeIDSmall);
        } else {
            return getDb().findAllByWhere(Drug.class, "ClinicID = " + clinicID + " and TypeID <> " + typeID);
        }
    }

    public List<Drug> getDrugByDrugNameAndClinicIDAndTypeIDSmallAndNotIncludeTypeID(String drugName, int clinicID,int typeIDSmall, int typeID) {
        if (typeIDSmall != 0) {
            return getDb().findAllByWhere(Drug.class,
                    "DrugName like '%" + drugName + "%' and ClinicID = " + clinicID + " and TypeID <> " + typeID + " and TypeIDSmall = " + typeIDSmall);
        } else {
            return getDb().findAllByWhere(Drug.class,
                    "DrugName like '%" + drugName + "%' and ClinicID = " + clinicID + " and TypeID <> " + typeID);
        }
    }

    public List<Drug> getDrugByClinicIDAndTypeID(int clinicID, int typeID) {
        return getDb().findAllByWhere(Drug.class, "ClinicID = " + clinicID + " and TypeID = " + typeID);
    }

    public List<Drug> getDrugByDrugNameAndClinicIDAndTypeID(String drugName, int clinicID, int typeID) {
        return getDb().findAllByWhere(Drug.class,
                "DrugName like '%" + drugName + "%' and ClinicID = " + clinicID + " and TypeID = " + typeID);
    }

    public List<Drug> getAllDrug() {
        return getDb().findAll(Drug.class);
    }

    public void deleteAllDrug() {
        getDb().deleteAll(Drug.class);
    }

    public void deleteAllDrugByClinicID(int ClinicID) {
        getDb().deleteByWhere(Drug.class, "ClinicID = " + ClinicID);
    }

}
