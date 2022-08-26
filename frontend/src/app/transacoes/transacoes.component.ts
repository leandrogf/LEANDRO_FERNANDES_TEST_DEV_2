import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Transacao } from '../models/transacao';
import { ContaBancariaService } from '../services/conta-bancaria.service';

@Component({
  selector: 'app-transacoes',
  templateUrl: './transacoes.component.html',
  styleUrls: ['./transacoes.component.scss'],
})
export class TransacoesComponent implements OnInit {
  idConta: number = 0;
  title = 'BANCO';
  public lista: Transacao[] = [];
  constructor(
    private cbService: ContaBancariaService,
    private route: ActivatedRoute
  ) {}

  ngOnInit(): void {
    this.route.params.subscribe((p) => {
      this.idConta = p['id'];
      this.refresh(this.idConta);
    });
  }

  public refresh(id: number) {
    this.cbService.listarTransacoes(id).subscribe((data) => {
      this.lista = data.sort((a, b) => {
        return <any>b.dataHora - <any>a.dataHora;
      });
    });
  }
}
