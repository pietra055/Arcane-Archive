import React from 'react';

export default function Ranking({ onVoltar }) {
  // Lista estática para exibir no modo demonstração
  const casas = [
    { id: 'AQUARIS', nome: 'Aquaris', pontuacao: 420 },
    { id: 'IGNIS', nome: 'Ignis', pontuacao: 380 },
    { id: 'VENTUS', nome: 'Ventus', pontuacao: 350 },
    { id: 'TERRAE', nome: 'Terrae', pontuacao: 290 },
  ];

  // Ordena a lista localmente pelo maior prestígio
  const casasOrdenadas = [...casas].sort((a, b) => b.pontuacao - a.pontuacao);

  return (
    <div className="relative z-10 w-full max-w-2xl bg-slate-950/80 border border-amber-500/20 p-8 rounded-2xl backdrop-blur-md shadow-2xl mx-auto mt-10">
      <h2 className="text-3xl font-serif font-bold text-amber-500 text-center mb-8 tracking-widest">
        🏆 Ranking das Casas
      </h2>

      <div className="space-y-4">
        {casasOrdenadas.map((casa, index) => (
          <div 
            key={casa.id} 
            className="flex justify-between items-center bg-slate-900/60 p-4 rounded-xl border border-slate-800 hover:border-amber-500/30 transition-all"
          >
            <div className="flex items-center gap-4">
              <span className={`text-2xl font-bold w-8 ${index === 0 ? 'text-yellow-400' : 'text-slate-500'}`}>
                {index + 1}º
              </span>
              <span className="font-serif text-xl text-slate-100">{casa.nome}</span>
            </div>
            <div className="text-right">
              <span className="block text-amber-400 font-bold text-lg">{casa.pontuacao}</span>
              <span className="text-[10px] text-slate-500 uppercase tracking-widest">Prestígio</span>
            </div>
          </div>
        ))}
      </div>

      <button 
        onClick={onVoltar}
        className="w-full mt-8 py-3 text-slate-400 hover:text-amber-400 uppercase tracking-widest text-xs transition-colors border-t border-slate-800"
      >
        ← Voltar ao Salão Comunal
      </button>
    </div>
  );
}