package com.pr.test.application.interfaces

interface IReadonlyService <T> {
    Set<T> listContas();
    T dadosConta(long id);
}
