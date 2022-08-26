import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ContaComponent } from './conta/conta.component';
import { TransacoesComponent } from './transacoes/transacoes.component';

const routes: Routes = [
  { path: "", component: ContaComponent},
  { path: "transacoes/:id", component: TransacoesComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
