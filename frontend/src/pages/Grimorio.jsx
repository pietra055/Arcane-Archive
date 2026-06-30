import React, { useState } from 'react';
import bgFeitico from '../assets/bg-feitico.png';

const FEITICOS_POR_CASA = {
  AQUARIS: [
    { id: 1, nome: "Hydro Sphere", descricao: "Controla esferas de água" },
    { id: 2, nome: "Water Shield", descricao: "Barreira líquida protetora" },
    { id: 3, nome: "Tsunami Burst", descricao: "Onda de impacto colossal" }
  ],
  IGNIS: [
    { id: 4, nome: "Fireball", descricao: "Projetil de fogo intenso" },
    { id: 5, nome: "Flame Wall", descricao: "Parede de chamas puras" },
    { id: 6, nome: "Inferno Strike", descricao: "Golpe de fogo descendente" }
  ],
  VENTUS: [
    { id: 7, nome: "Wind Slash", descricao: "Corte de vento afiado" },
    { id: 8, nome: "Tornado", descricao: "Vórtice de ar giratório" },
    { id: 9, nome: "Air Shield", descricao: "Escudo de ar comprimido" }
  ],
  TERRAE: [
    { id: 10, nome: "Stone Wall", descricao: "Parede de rocha sólida" },
    { id: 11, nome: "Earthquake", descricao: "Tremor de terra local" },
    { id: 12, nome: "Vine Trap", descricao: "Armadilha de vinhas selvagens" }
  ]
};

export default function Grimorio({ casa, onVoltar, onAtualizarPontos }) {
  const [feiticosAprendidos, setFeiticosAprendidos] = useState([]);
  const nomeCasa = casa?.id || 'AQUARIS'; // Usa o ID da casa para filtrar
  const listaFeiticos = FEITICOS_POR_CASA[nomeCasa] || [];

  const handleAprenderFeitico = (feitico) => {
    if (feiticosAprendidos.includes(feitico.id)) return;
    
    setFeiticosAprendidos([...feiticosAprendidos, feitico.id]);
    
    // Adiciona pontos de forma fictícia para teste
    if (onAtualizarPontos) onAtualizarPontos(20);
    alert(`🔮 Você dominou o feitiço: ${feitico.nome}!`);
  };

  return (
    <div className="relative min-h-screen bg-cover bg-center p-8 flex flex-col items-center" style={{ backgroundImage: `url(${bgFeitico})` }}>
      {/* HEADER FIXO */}
      <header className="w-full max-w-6xl flex justify-between items-center bg-slate-950/40 p-4 rounded-xl border border-amber-500/20 backdrop-blur-md">
        <button onClick={onVoltar} className="text-sm text-slate-300 hover:text-amber-400">← Voltar ao Salão</button>
        <h1 className="text-2xl font-serif font-bold text-amber-500">📖 Grimório: {nomeCasa}</h1>
      </header>

      {/* CONTEÚDO */}
      <main className="w-full max-w-6xl grid grid-cols-1 md:grid-cols-3 gap-8 mt-8 flex-grow">
        
        {/* Coluna de Feitiços */}
        <div className="md:col-span-2 bg-slate-950/20 p-6 rounded-2xl border border-slate-800/50 backdrop-blur-sm min-h-[400px]">
          <div className="space-y-4">
            {listaFeiticos.map(f => (
              <div key={f.id} className="bg-slate-900/60 p-4 rounded-lg border border-slate-700 flex justify-between items-center">
                <div>
                  <h4 className="font-bold text-white">{f.nome}</h4>
                  <p className="text-xs text-slate-400">{f.descricao}</p>
                </div>
                <button 
                  disabled={feiticosAprendidos.includes(f.id)}
                  onClick={() => handleAprenderFeitico(f)}
                  className={`px-4 py-2 rounded text-[10px] transition-all ${feiticosAprendidos.includes(f.id) ? 'bg-emerald-950 text-emerald-400' : 'bg-slate-800 text-white hover:bg-amber-900'}`}
                >
                  {feiticosAprendidos.includes(f.id) ? '✓ Dominado' : '🔮 Estudar'}
                </button>
              </div>
            ))}
          </div>
        </div>

        {/* Coluna Lateral */}
        <div className="md:col-span-1 bg-slate-950/20 p-6 rounded-2xl border border-slate-800/50 backdrop-blur-sm h-fit">
          <h3 className="text-amber-500 font-serif text-lg mb-4">Linhagem de {nomeCasa}</h3>
          <p className="text-xs text-slate-400 leading-relaxed">
            Bruxos desta linhagem possuem acesso aos arcanos estudados no Grimório. O domínio destes feitiços eleva o prestígio da sua casa.
          </p>
        </div>
      </main>
    </div>
  );
}