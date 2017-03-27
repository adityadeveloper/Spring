<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div style="margin: 10px;">
<h4>List of Persons</h4>
<table style="width: 600px" class="reference">
<tbody>
<tr>
<th>Sr. No.</th>
<th>Name</th>
<th>Age</th>
<th>Email</th>
</tr>
<c:forEach var="person" items="${requestScope.persons}"
varStatus="loopCounter">
<tr>
<td><c:out value="${loopCounter.count}" /></td>
<td><c:out value="${person.name}" /></td>
<td><c:out value="${person.email}" /></td>
<td><c:out value="${person.age}" /></td>
</tr>
</c:forEach>
</tbody>
</table>
</div>