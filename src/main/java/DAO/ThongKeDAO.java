package DAO;

import java.util.List;

import Entity.Chart;
import Entity.ThongKe;

public interface ThongKeDAO {

	List<Chart> getAllThongKe(int year, int index);

	List<Chart> getChart(int year);

	int countThongKe(int year);

	String getLastedYear();

	List<String> getYear();

	String getLastedYearByStore(int storeId);

	List<String> getYearByStore(int storeId);

	int countThongKeByStore(int year, int storeId);

	int getMonthMinByStore(int year, int storeId);

	List<Chart> getChartByStore(int year, int storeId);

	List<ThongKe> getAllThongKeByStore(int year, int storeId, int index);

}
