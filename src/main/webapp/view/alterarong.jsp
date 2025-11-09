<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib prefix="c" uri="jakarta.tags.core" %>
        <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
            <jsp:include page="layouttopo.jsp"></jsp:include>
            <div class="row">
                <div class="card">
                    <div class="card2">
                        <h1>Alteração de Série</h1>

                        <!-- Formulário de alteração de dados da ONG -->
                        <form:form action="/alterarong" modelAttribute="ong">
                            <label for="id">Id:</label>
                            <input type="number" value="${ong.getId()}" disabled>
                            <input type="hidden" id="id" name="id" value="${ong.getId()}">

                            <label for="nome">Nome da ONG:</label>
                            <input type="text" id="nome" name="nome" maxlength="100" value="${ong.getNome()}">

                            <label for="responsavel">Nome do responsável:</label>
                            <input type="text" id="responsavel" name="responsavel" maxlength="100"
                                value="${ong.getResponsavel()}">

                            <label for="generoResponsavel">Gênero do responsável:</label>
                            <select id="genero" name="generoResponsavel" value="${ong.getGeneroResponsavel()}">
                                <option value="Feminino">Feminino</option>
                                <option value="Masculino">Masculino</option>
                                <option value="Prefiro não dizer">Prefiro não dizer</option>
                            </select>

                            <label for="cidade">Cidade:</label>
                            <input type="text" id="cidade" name="cidade" maxlength="120" value="${ong.getCidade()}">

                            <button>Alterar</button>
                        </form:form>
                    </div>
                </div>
            </div>
            <jsp:include page="layoutrodape.jsp"></jsp:include>