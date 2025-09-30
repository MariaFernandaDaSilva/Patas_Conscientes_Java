<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<jsp:include page="layouttopo.jsp"></jsp:include>
    <c:set var="nome" value="Maria"></c:set>
    <div class="row">
        <div class="card">
            <h1>Colaboradores</h1>
            <ul>
                <c:forEach items="${colaboradores}" var="colaborador">
                    <li>${colaborador}</li>
                </c:forEach>
            </ul>
            <c:if test="${exibir}">
                <p>Lista atualizada de colaboradores.</p>
                <p>Responsável: ${nome}</p>
            </c:if>
        </div>
    </div>
<jsp:include page="layoutrodape.jsp"></jsp:include>