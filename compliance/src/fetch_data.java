import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import com.connection.MyConnection;
import com.pojo.trade;

public class fetch_data {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Connection con = MyConnection.getMyConnection();
		List<trade> list = new ArrayList<trade>();
		String find_all_trades = "select * from Test_Generator_KC";
		try {
			Statement st = con.createStatement();
			ResultSet set = st.executeQuery(find_all_trades);
			trade tr;
			while (set.next()) {
				tr = new trade(set.getInt(1), set.getString(2), set.getString(3), set.getString(4), set.getString(5),
						set.getString(6), set.getString(7), set.getString(8), set.getInt(9), set.getDouble(10),
						set.getDouble(11));
				list.add(tr);

				// System.out.println(trade_number+" "+name+" "+quantity);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

//		for(int i=0;i<1000;i++){
//		    System.out.println(list.get(i).toString() + i);
//		} 

		List<Integer> fraud_traders = new ArrayList<Integer>();
		System.out.println(list.size());
		int c = 0,d = 0;
		
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getCLASS().equals("Trader")) {
				for (int j = i; j < list.size(); j++) {
					
					if(LocalTime.parse(list.get(j).getTRADE_TIME())
							.isAfter(LocalTime.parse(list.get(i).getTRADE_TIME()).plusSeconds(60)))break;
						
					
					if (list.get(j).getCLASS().equals("Client") && LocalTime.parse(list.get(j).getTRADE_TIME())
							.isBefore(LocalTime.parse(list.get(i).getTRADE_TIME()).plusSeconds(60)))
						
					{
						if ((list.get(j).getTRADE_TYPE().equals(list.get(i).getTRADE_TYPE())
								&& list.get(j).getSTOCK().equals(list.get(i).getSTOCK())))
							
						{
							c++;
							if( list.get(j).getSECURITY_TYPE().equals(list.get(i).getSECURITY_TYPE())) 
							{

							fraud_traders.add(list.get(i).getTRADE_NUMBER());
							
							if (list.get(i).getTRADE_TYPE().equals("B"))
								{
								System.out.println(list.get(i).getTRADE_NUMBER() + "    " + list.get(j).getTRADE_NUMBER()+"	 Scenario: 1");
								}
							else
								{
								System.out.println(list.get(i).getTRADE_NUMBER() + "    " + list.get(j).getTRADE_NUMBER()+"	 Scenario: 2");
								}
							
							}
							
							else {
								System.out.println(list.get(i).getTRADE_NUMBER() + "    " + list.get(j).getTRADE_NUMBER()+"	 Scenario: 4");
							}
						
						}
					}
				}
				
				
				
				int trader_sum=0,clients_sum=0;
				
				List<Integer> frauds_sen3 = new ArrayList<>();
				List<Integer> clients_sen3 = new ArrayList<>();
				
				trader_sum=trader_sum+list.get(i).getQUANTITY();
				frauds_sen3.add(list.get(i).getTRADE_NUMBER());
				
				for (int j = i+1; j < list.size(); j++) {
					if(LocalTime.parse(list.get(j).getTRADE_TIME())
							.isAfter(LocalTime.parse(list.get(i).getTRADE_TIME()).plusSeconds(60)))break;
					if (LocalTime.parse(list.get(j).getTRADE_TIME())
							.isBefore(LocalTime.parse(list.get(i).getTRADE_TIME()).plusSeconds(60))) {
						if (((list.get(j).getTRADE_TYPE().equals("B") && list.get(i).getTRADE_TYPE().equals("B"))
								&& list.get(j).getSTOCK().equals(list.get(i).getSTOCK()))) {
							if( list.get(j).getSECURITY_TYPE().equals(list.get(i).getSECURITY_TYPE())) {
								if(list.get(j).getCLASS().equals("Client") ) {
									clients_sum=clients_sum+list.get(j).getQUANTITY();
									
									clients_sen3.add(list.get(j).getTRADE_NUMBER());
									
								}
								if(list.get(j).getCLASS().equals("Trader") && list.get(j).getNAME().equals(list.get(i).getNAME())){
									trader_sum=trader_sum+list.get(j).getQUANTITY();
									
									frauds_sen3.add(list.get(j).getTRADE_NUMBER());
									
								}
							}
						}
					}
					
				}
				if (trader_sum==clients_sum) {
				System.out.println(frauds_sen3.toString());
				
				System.out.println(clients_sen3.toString());
				
				System.out.println("scenario:3");
				
				
				d++;
				}
				}
			}
		System.out.println(c+"	"+d);
//	for (int i=1;i<fraud_traders.size();i++) {
//		System.out.println(fraud_traders.get(i));
//	}
		
	}

}
