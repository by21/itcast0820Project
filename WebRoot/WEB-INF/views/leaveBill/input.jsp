<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/js/commons.jspf" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<html>
<head>
<script>
function  GetDateDiff(startDate,endDate)  
{  
    var startTime = new Date(Date.parse(startDate.replace(/-/g,   "/"))).getTime();     
    var endTime = new Date(Date.parse(endDate.replace(/-/g,   "/"))).getTime();     
    var dates = Math.abs((startTime - endTime))/(1000*60*60*24);     
    return  dates;    
}
</script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>请假管理</title>
</head>
<body>
 	<form action="leaveBillAction_save2.action" method="POST">
 		<table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
		  <tr>
		    <td height="30"><table width="100%" border="0" cellspacing="0" cellpadding="0">
		      <tr>
		        <td height="24" bgcolor="#353c44"><table width="100%" border="0" cellspacing="0" cellpadding="0">
		          <tr>
		            <td><table width="100%" border="0" cellspacing="0" cellpadding="0">
		              <tr>
		                <td width="6%" height="19" valign="bottom"><div align="center"><img src="${pageContext.request.contextPath }/images/tb.gif" width="14" height="14" /></div></td>
		                <td width="94%" valign="bottom">
		                	<span class="STYLE1">
		                			新增/修改请假申请
		                	</span>
		                	</td>
		              </tr>
		            </table></td>
		            <td><div align="right"><span class="STYLE1">
		              </span></div></td>
		          </tr>
		        </table></td>
		      </tr>
		    </table></td>
		  </tr>
		  <tr>
		    <td>
		    	<div align="left" class="STYLE21">
		    		<s:hidden name="id"></s:hidden>
		    		<s:hidden name="user.id"></s:hidden>
		 
				            开始时间：  <input type="text" class="Wdate" id="startTime" name="startTime" onFocus="WdatePicker({onpicked:function(){$dp.$('days').value=1+GetDateDiff($dp.$('startTime').value,$dp.$('endTime').value);},readOnly:true,maxDate:'#F{$dp.$D(\'endTime\')}'})"/><br/>
				             结束时间：  <input type="text" class="Wdate" id="endTime" name="endTime" onFocus="WdatePicker({onpicked:function(){$dp.$('days').value=1+GetDateDiff($dp.$('startTime').value,$dp.$('endTime').value);},readOnly:true,minDate:'#F{$dp.$D(\'startTime\')}'})"/>  <br/><br/>
			 		请假天数：  <input type="text" id="days" name="days" /><br/><br/>
			 		<!-- 请假天数：  <s:textfield id="days" name="days" cssStyle="width: 200px;"/><br/> -->
			 		请假原因：  <s:textarea name="content" cols="50" row="3"/><br/><br/>
			 		备&emsp;&emsp;注：  <s:textarea name="remark" cols="50" rows="5"/><br/><br/>
			 		<input type="submit" value="保  存" class="button_ok" style="width: 59px; height: 35px; "/>
			 			
				</div>
		    </td>
		  </tr>
	</table>
	 	
	</form>
</body>
</html>