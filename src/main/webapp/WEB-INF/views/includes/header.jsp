<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="header">
  <div class="header-inner">
    <div class="brand">Basic Login CRUD</div>
    <nav class="nav">
      <a href="${pageContext.request.contextPath}/admin/login" class="back">Home</a>
      <c:if test="${not empty sessionScope.ADMIN_USERNAME}">
        <a href="${pageContext.request.contextPath}/users" class="back">Users</a>
        <a href="${pageContext.request.contextPath}/admin/list" class="back">Admins</a>
        <a href="${pageContext.request.contextPath}/vehicles" class="back">Vehicles</a>
        <a href="${pageContext.request.contextPath}/admin/dashboard" class="back">Dashboard</a>
      </c:if>
    </nav>
  </div>
  <c:if test="${not empty sessionScope.ADMIN_USERNAME}">
    <div style="max-width:1100px;margin:0 auto;padding:0 20px 10px;color:#6b7280;">
      Logged in as ${sessionScope.ADMIN_USERNAME}
    </div>
  </c:if>
</div>
