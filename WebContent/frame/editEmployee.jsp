<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head></head>
<body>
	<s:form id="saveForm" action="employee_update" method="post"
		namespace="/">
		<s:textfield name="eid" value="%{model.eid}">
		</s:textfield>
		<table border="0" width="600px">
			<tr>
				<td align="center" style="font-size: 24px; color: #666">员工编辑</td>
			</tr>
			<tr>
				<td align="right"><a
					href="javascript:document.getElementById('saveForm').submit()">保存</a>
					&nbsp;&nbsp; <a href="javascript:history.go(-1)">退回 </a>></td>
			</tr>
		</table>
		<br />


		<table border='0' cellpadding="0" cellspacing="10">

			<!-- private Integer eid;
	private String ename;
	private String sex;
	private Date birthday;
	private Date joinDate;
	private String eno;
	private String username;
	private String password;
	private Department department;
 -->
			<tr>

				<td>姓名</td>
				<td><s:textfield name="ename" value="%{model.ename}" /></td>
				<td>性别</td>
				<td><s:textfield name="sex" value="%{model.sex}" /></td>

				<td>用户登录名</td>
				<td><s:textfield name="username" value="%{model.username}" /></td>
				<td>用户密码</td>
				<td><s:textfield type="password" name="password"
						value="%{model.password}" /></td>
			</tr>
			<tr>
				<td>出生日期</td>
				<td><input type="text" name="birthday"
					value="<s:date name="%{model.birthday}" format="yyyy-MM-dd" />" />
					<%-- 	<s:textfield  name="birthday" value="%{model.birthday}" /> --%></td>
				<td>入职时间</td>
				<td><input type="text" name="joinDate"
					value="<s:date
						name="%{model.joinDate}" format="yyyy-MM-dd" />" />
					<%-- 		<s:textfield name="joinDate" value="%{model.joinDate}" /> --%>
				</td>
			</tr>

			<tr>
				<td>所属部门</td>
				<!-- list：在acton中存入 -->
				<td><s:select name="department.did" list="list"
						value="%{model.department.did}" listKey="did" listValue="dname"
						headerKey="" headerValue="--请选择--" /></td>
				<td>编号</td>
				<td><s:textfield name="eno" value="%{model.eno}" /></td>
			</tr>
		</table>

	</s:form>
</body>
</html>