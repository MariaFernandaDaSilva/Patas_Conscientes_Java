<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
	<%@ taglib prefix="c" uri="jakarta.tags.core" %>
		<jsp:include page="layouttopo.jsp"></jsp:include>
    <div class="row">
        <div class="card">
            <h1>Empresa ABC</h1>
            <p>Página de apresentação da empresa.</p>
            <p>${texto}</p>
        </div>
    </div>
    <jsp:include page="layoutrodape.jsp"></jsp:include>