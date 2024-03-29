package miniCasino;

public class MiniCasinoDAO extends DBConn{
	private String sql = "";
	private MiniCasinoVO vo = new MiniCasinoVO();
	
	public int getLoginInfo(String id, String password) {
		int res = 0;
		try {
			sql = "select * from cstInfo where id = ? && password = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, password);
			rs = pstmt.executeQuery();
			if(rs.next())
			{
				res = 1;
			}
			else res = 0;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			rsClose();
		}
		
		return res;
	}
	
}
