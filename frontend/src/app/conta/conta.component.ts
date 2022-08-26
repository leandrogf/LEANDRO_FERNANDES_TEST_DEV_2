import { Component, OnInit } from '@angular/core';
import { ContaBancaria } from '../models/conta-bancaria';
import { ContaBancariaService } from '../services/conta-bancaria.service';

@Component({
  selector: 'app-conta',
  templateUrl: './conta.component.html',
  styleUrls: ['./conta.component.scss']
})
export class ContaComponent {

  title = 'BANCO';
  public lista: ContaBancaria[] = [];
  constructor(private cbService: ContaBancariaService) {
    this.refresh();
  }

  public refresh(){
    this.cbService.listarContas().subscribe((data) => {
      this.lista = data.sort((a, b) => a.nomeCliente.localeCompare(b.nomeCliente));
    })
  }

}
