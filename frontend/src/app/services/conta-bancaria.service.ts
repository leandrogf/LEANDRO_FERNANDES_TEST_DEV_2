import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { ContaBancaria } from '../models/conta-bancaria';
import { Transacao } from '../models/transacao';

@Injectable({
  providedIn: 'root'
})
export class ContaBancariaService {

  private baseUrl = "http://localhost:8080/contas"

  constructor(private http: HttpClient) { }

  public listarContas(){
    return this.http.get<ContaBancaria[]>(this.baseUrl);
  }

  public listarTransacoes(idConta: number){
    return this.http.get<Transacao[]>(`${this.baseUrl}/${idConta}/transacoes`);
  }
}
