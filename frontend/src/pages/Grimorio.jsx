import React, { useState, useEffect } from 'react';
import axios from 'axios';
import bgFeitico from '../assets/bg-feitico.png';

const FEITICOS_POR_CASA = {
  AQUARIS: ["Hydro Sphere", "Water Shield", "Tsunami Burst", "Ice Lance", "Healing Rain", "Incendio Arcano", "Escudo de Éter", "Lúmen Divino"],
  IGNIS: ["Fireball", "Flame Wall", "Inferno Strike", "Burning Aura", "Phoenix Blaze", "Incendio Arcano", "Escudo de Éter", "Lúmen Divino"],
  VENTUS: ["Wind Slash", "Tornado", "Air Shield", "Sonic Wave", "Feather Step", "Incendio Arcano", "Escudo de Éter", "Lúmen Divino"],
  TERRAE: ["Stone Wall", "Earthquake", "Vine Trap", "Crystal Armor", "Nature Blessing", "Incendio Arcano", "Escudo de Éter", "Lúmen Divino"]
};

export default function Grimorio({ casa, bruxoDados, onVoltar, onAtualizarPontos }) {
  const [feiticos, setFeiticos] = useState([]);
  const [feiticosAprendidos, setFeiticosAprendidos] = useState([]);
  const nomeCasa = casa?.nome || 'AQUARIS';

  useEffect(() => {
    const buscarFeiticosDoBanco = async () => {
      try {
        const response = await axios.get('http://localhost:8080/feiticos');
        setFeiticos(response.data);
      } catch (error) {
        console.error("Backend offline ou erro de conexão:", error);
      }
    };
    buscarFeiticosDoBanco();
  }, []);

  const handleAprenderFeitico = async (feitico) => {
    if (feiticosAprendidos.includes(feitico.id)) return;
    try {
      await axios.post(`http://localhost:8080/bruxos/${bruxoDados?.id}/feiticos/${feitico.id}`);
      setFeiticosAprendidos([...feiticosAprendidos, feitico.id]);
      const pontos = feitico.dificuldade === 'AVANCADO' ? 30 : feitico.dificuldade === 'INTERMEDIARIO' ? 20 : 10;
      if (onAtualizarPontos) onAtualizarPontos(pontos);
    } catch (error) {
      console.error("Erro ao aprender:", error);
    }
  };

  return (
    <div className="relative min-h-screen bg-cover bg-center p-8 flex flex-col items-center" style={{ backgroundImage: `url(${bgFeitico})` }}>
      {/* HEADER FIXO */}
      <header className="w-full max-w-6xl flex justify-between items-center bg-slate-950/40 p-4 rounded-xl border border-amber-500/20 backdrop-blur-md">
        <button onClick={onVoltar} className="text-sm text-slate-300 hover:text-amber-400">← Voltar ao Salão</button>
        <h1 className="text-2xl font-serif font-bold text-amber-500">📖 Grimório: {nomeCasa}</h1>
      </header>

      {/* CONTEÚDO COM MOLDURA FIXA */}
      <main className="w-full max-w-6xl grid grid-cols-1 md:grid-cols-3 gap-8 mt-8 flex-grow">
        
        {/* Coluna de Feitiços */}
        <div className="md:col-span-2 bg-slate-950/20 p-6 rounded-2xl border border-slate-800/50 backdrop-blur-sm min-h-[400px]">
          {feiticos.length === 0 ? (
            <p className="text-slate-500 text-center mt-20 italic">O grimório está em sincronização com o banco de dados...</p>
          ) : (
            <div className="space-y-4">
              {feiticos.filter(f => FEITICOS_POR_CASA[nomeCasa]?.includes(f.nome)).map(f => (
                <div key={f.id} className="bg-slate-900/60 p-4 rounded-lg border border-slate-700 flex justify-between items-center">
                  <div>
                    <h4 className="font-bold text-white">{f.nome}</h4>
                    <p className="text-xs text-slate-400">{f.descricao}</p>
                  </div>
                  <button 
                    disabled={feiticosAprendidos.includes(f.id)}
                    onClick={() => handleAprenderFeitico(f)}
                    className={`px-4 py-2 rounded text-[10px] ${feiticosAprendidos.includes(f.id) ? 'bg-emerald-950 text-emerald-400' : 'bg-slate-800 text-white hover:bg-amber-900'}`}
                  >
                    {feiticosAprendidos.includes(f.id) ? '✓ Dominado' : '🔮 Estudar'}
                  </button>
                </div>
              ))}
            </div>
          )}
        </div>

        {/* Coluna Lateral (Painel) */}
        <div className="md:col-span-1 bg-slate-950/20 p-6 rounded-2xl border border-slate-800/50 backdrop-blur-sm h-fit">
          <h3 className="text-amber-500 font-serif text-lg mb-4">Linhagem de {nomeCasa}</h3>
          <p className="text-xs text-slate-400 leading-relaxed">
            Bruxos desta linhagem possuem acesso apenas aos arcanos permitidos pelo Grande Arquivo. O estudo destes feitiços eleva o prestígio da sua casa.
          </p>
        </div>

      </main>
    </div>
  );
}