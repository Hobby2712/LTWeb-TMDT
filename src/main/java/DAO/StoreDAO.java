package DAO;

import Entity.Store;

public interface StoreDAO {

	int GetStoreIdFromUID(int uId);

	Store getStoreById(int sId);

}
