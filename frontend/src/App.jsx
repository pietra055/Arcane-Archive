import React, { useState } from 'react';
import SelecaoCasa from './pages/SelecaoCasa';
import CadastroBruxo from './pages/CadastroBruxo';
import SalaoComunal from './pages/SalaoComunal';
import Grimorio from './pages/Grimorio';
import Ranking from './pages/Ranking';

export default function App() {
  const [tela, setTela] = useState('selecao'); // 'selecao', 'cadastro', 'salaoComunal'
  const [casaSelecionada, setCasaSelecionada] = useState(null);
  const [dadosBruxo, setDadosBruxo] = useState(null);

  // 1. Quando escolhe a casa lá na primeira tela
  const handleSelecionarCasa = (casa) => {
    setCasaSelecionada(casa);
    setTela('cadastro'); // Vai para o formulário
  };

  // 2. Quando o cadastro dá sucesso (O que corrige o seu bug!)
  const handleCadastroSucesso = (dadosVindosDoFormulario) => {
    setDadosBruxo(dadosVindosDoFormulario); // Salva o nome, idade, etc.
    setTela('salaoComunal'); // Avança para o Dashboard em vez de voltar!
  };

  // Gerenciador de Telas
  return (
    <div className="min-h-screen bg-slate-950 text-slate-100 font-sans">
      {tela === 'selecao' && (
        <SelecaoCasa onSelecionarCasa={handleSelecionarCasa} />
      )}

      {tela === 'cadastro' && (
        <CadastroBruxo 
          casa={casaSelecionada} 
          onVoltar={() => setTela('selecao')} 
          onCadastroSucesso={handleCadastroSucesso} // Passando a correção aqui
        />
      )}

      {tela === 'salaoComunal' && (
        <SalaoComunal 
          casa={casaSelecionada}
          bruxoDados={dadosBruxo}
          onDeslogar={() => {
            setDadosBruxo(null);
            setCasaSelecionada(null);
            setTela('selecao'); // Reseta ao clicar em Sair
          }}
          onNavegar={(destino) => setTela(destino)}
        />
      )}
      {tela === 'grimorio' && (
        <Grimorio 
          casa={casaSelecionada}
          bruxoDados={dadosBruxo}
          onVoltar={() => setTela('salaoComunal')}
          onAtualizarPontos={(pontosNovos) => setPontos(prev => prev + pontosNovos)} 
        />
      )}
      {tela === 'ranking' && (
        <Ranking
          onVoltar={() => setTela('salaoComunal')}
        />
      )}
    </div>
  );
}