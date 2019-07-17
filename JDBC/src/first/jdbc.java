package first;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class jdbc {

	public static void main(String[] args) {
		Connection conn=null;
		Statement state=null;
		Statement state2=null;
		ResultSet rs=null;
		//加载驱动
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/newschool","root","root");
			//System.out.println(conn);
		//编写sql并执行
			String sql="insert into grade(low,upp,rank) values('30','100','A')";//增加
			String mysql="update grade set low='50' where low='30' ";//修改
			String sql2="delete from grade where low='30'";//删除
			String sql3="select low from grade";
			state=conn.createStatement();
			state2=conn.createStatement();//增删改
			rs=state.executeQuery(sql3);//查
//			
//			int count=state.executeUpdate(sql);
//			int count2=state.executeUpdate(mysql);
//			if(count==1){
//				System.out.println("添加成功");
//			}else{
//				System.out.println("添加失败");
//			}
//			if(count2==1){
//				System.out.println("修改成功");
//			}else{
//				System.out.println("修改失败");
//			}
			//处理返回结果
			while(rs.next()){
				System.out.println(rs.getString("low"));
			}
			//关闭资源
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
					try {
						if(rs!=null){
						rs.close();
						}
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
						try {
							if(state!=null)
							state.close();
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
							finally{
								   try {
									   if(state2!=null)
									state2.close();
								} catch (SQLException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								
								}finally{
										try {
											if(rs!=null)
											rs.close();
										} catch (SQLException e) {
											// TODO Auto-generated catch block
											e.printStackTrace();
										}
									}
								
					}
				}
			
		}
	}
