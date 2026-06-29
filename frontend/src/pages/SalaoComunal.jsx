import React, { useState, useEffect } from 'react';
import axios from 'axios';
import bgMenu from '../assets/bg-menu.png'; // Atualizado para a nova imagem mística

export default function SalaoComunal({ bruxoDados, casa, onDeslogar, onNavegar }) {
  const [pontosCasa, setPontosCasa] = useState(0);
  const [carregando, setCarregando] = useState(true);

  // Mapeamento de estilos integrado com o ecossistema
  const estilosCasas = {
    AQUARIS: { texto: 'text-cyan-400', badge: 'bg-cyan-950/40 text-cyan-400 border-cyan-500/20' },
    IGNIS: { texto: 'text-orange-500', badge: 'bg-orange-950/40 text-orange-400 border-orange-500/20' },
    VENTUS: { texto: 'text-emerald-400', badge: 'bg-emerald-950/40 text-emerald-400 border-emerald-500/20' },
    TERRAE: { texto: 'text-amber-600', badge: 'bg-amber-950/40 text-amber-400 border-amber-700/20' },
  };

  const configVisual = estilosCasas[casa.id] || estilosCasas.AQUARIS;

   useEffect(() => {
    const buscarPontuacaoAtualizada = async () => {
      try {
        setCarregando(true);
        // Utiliza o ID da casa vindo da props para buscar no backend
        const response = await axios.get(`http://localhost:8080/casas/${casa.id}`);
        
        // Acessa o campo 'pontuacao' definido no seu Model/Service
        setPontosCasa(response.data.pontuacao);
      } catch (error) {
        console.error("Erro ao sincronizar com o Grande Arquivo:", error);
      } finally {
        setCarregando(false);
      }
    };

    if (casa?.id) {
      buscarPontuacaoAtualizada();
    }
  }, [casa.id]);
 

  return (
    <div 
      className="relative min-h-screen bg-cover bg-center bg-no-repeat flex flex-col items-center justify-between p-8 select-none"
      style={{ backgroundImage: `url(${bgMenu})` }}
    >
      {/* Removido o overlay preto total para preservar o fundo do ChatGPT Image 29 de jun. de 2026, 12_59_37.png */}

      {/* HEADER DO SALÃO COMUNAL - Mais sutil para não brigar com o topo do castelo */}
      <header className="relative z-10 w-full max-w-5xl flex flex-col sm:flex-row justify-between items-center bg-slate-950/40 border border-amber-500/10 p-4 rounded-xl backdrop-blur-xs gap-4">
        <div className="flex items-center gap-3">
          <div className={`w-2.5 h-2.5 rounded-full bg-current ${configVisual.texto} animate-pulse`} />
          <h1 className="text-lg font-serif font-bold tracking-wider text-slate-200">
            Arcane Archive <span className="text-xs text-slate-500 font-sans font-normal">| Painel</span>
          </h1>
        </div>
        
        <div className="flex items-center gap-4">
          <span className={`text-xs font-bold px-3 py-0.5 rounded-full border ${configVisual.badge}`}>
            Linhagem {casa.nome}
          </span>
          <button 
            onClick={onDeslogar}
            className="text-xs text-rose-400/80 hover:text-rose-400 uppercase tracking-widest transition-colors cursor-pointer"
          >
            Sair →
          </button>
        </div>
      </header>

      {/* PAINEL CENTRAL - EXPANDIDO: Mudamos de max-w-3xl para max-w-5xl e aumentamos o grid */}
      <main className="relative z-10 w-full max-w-5xl grid grid-cols-1 md:grid-cols-3 gap-8 my-auto items-stretch px-6 md:px-12">
        
        {/* PERFIL DO CONJURADOR - Mais largo, com textos maiores e padding aumentado */}
        <div className="md:col-span-1 bg-slate-950/40 border border-amber-500/10 rounded-2xl p-8 text-center flex flex-col items-center justify-center backdrop-blur-xs min-h-[320px]">
          <div className="w-20 h-20 rounded-full border border-amber-500/20 bg-slate-900/60 flex items-center justify-center text-4xl shadow-inner mb-4 animate-pulse">
            🧙‍♂️
          </div>
          <span className="text-[10px] uppercase font-bold tracking-[0.2em] text-slate-500">Conjurador</span>
          <h3 className="text-2xl font-serif font-bold text-slate-100 mt-1 break-words w-full">
            {bruxoDados?.nome || "Albus Custos"}
          </h3>
          <div className="w-16 h-[1px] bg-slate-800/60 my-4"></div>
          
          <div className="space-y-3 text-left w-full text-sm">
            <div className="flex justify-between border-b border-slate-900/40 pb-1.5">
              <span className="text-slate-400">Idade Terrena:</span>
              <span className="text-slate-200 font-bold">{bruxoDados?.idade || 17} anos</span>
            </div>
            <div className="flex justify-between border-b border-slate-900/40 pb-1.5">
              <span className="text-slate-400">Ano Escolar:</span>
              <span className="text-slate-200 font-bold">1º Ano (Neófito)</span>
            </div>
            <div className="flex justify-between">
              <span className="text-slate-400">Afinidade:</span>
              <span className={`${configVisual.texto} font-bold uppercase tracking-wider`}>{bruxoDados?.nivelMagia || "Iniciante"}</span>
            </div>
          </div>
        </div>

        {/* CONTADOR & MENUS - Ocupando mais espaço vertical e horizontal */}
        <div className="md:col-span-2 flex flex-col gap-6 justify-between">
          
          {/* PLACAR MÍSTICO - Texto gigante para dar o peso que a pontuação merece */}
          <div className="bg-slate-950/40 border border-amber-500/10 rounded-2xl p-8 text-center flex flex-col justify-center items-center flex-1 backdrop-blur-xs min-h-[160px]">
            <h4 className="text-xs uppercase font-bold tracking-[0.25em] text-slate-400">Prestígio da Linhagem</h4>
            <div className="flex items-baseline justify-center gap-3 mt-2">
              <span className={`text-6xl md:text-7xl font-serif font-bold tracking-tighter ${configVisual.texto} drop-shadow-[0_0_15px_rgba(245,158,11,0.1)]`}>
                {pontosCasa}
              </span>
              <span className="text-sm uppercase tracking-widest text-slate-500 font-bold">Pontos</span>
            </div>
          </div>

          {/* MENUS DE NAVEGAÇÃO - Botões maiores com ícones destacados */}
          <div className="grid grid-cols-2 gap-6">
            <button 
              onClick={() => onNavegar('grimorio')}
              className="bg-slate-950/50 border border-slate-800/60 hover:border-amber-500/30 p-6 rounded-xl text-center group transition-all duration-300 active:scale-95 cursor-pointer backdrop-blur-xs min-h-[120px] flex flex-col justify-center items-center"
            >
              <div className="text-3xl mb-2 group-hover:scale-110 transition-transform">📖</div>
              <h5 className="text-sm font-bold uppercase tracking-wider text-slate-200 group-hover:text-amber-400 transition-colors">Grimório Arcano</h5>
              <p className="text-[10px] text-slate-500 mt-1 hidden sm:block">Forjar e listar feitiços antigos</p>
            </button>

            <button 
              onClick={() => onNavegar('ranking')}
              className="bg-slate-950/50 border border-slate-800/60 hover:border-amber-500/30 p-6 rounded-xl text-center group transition-all duration-300 active:scale-95 cursor-pointer backdrop-blur-xs min-h-[120px] flex flex-col justify-center items-center"
            >
              <div className="text-3xl mb-2 group-hover:scale-110 transition-transform">📜</div>
              <h5 className="text-sm font-bold uppercase tracking-wider text-slate-200 group-hover:text-amber-400 transition-colors">Ranking de Casas</h5>
              <p className="text-[10px] text-slate-500 mt-1 hidden sm:block">Verificar a pontuação da sua casa</p>
            </button>
          </div>

        </div>
      </main>

      {/* RODAPÉ */}
      <footer className="relative z-10 w-full text-center opacity-60">
        <p className="text-[9px] text-slate-500 uppercase tracking-widest">
          Santuário Arcano • Edição 2026
        </p>
      </footer>
    </div>
  );
}