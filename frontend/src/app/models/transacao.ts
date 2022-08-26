import { ContaBancaria } from "./conta-bancaria";

export class Transacao {
    public idConta: number | undefined;
    public dataHora: Date = new Date();
    public historico: string = '';
    public valor: number = 0;
    public saldoAnterior: number = 0;
}
