import React, { useState } from 'react';
import bgCastle from '../assets/bg-castle.png';
import cardAquaris from '../assets/card-aquaris.png';
import cardIgnis from '../assets/card-ignis.png';
import cardVentus from '../assets/card-ventus.png';
import cardTerrae from '../assets/card-terrae.png';

export default function SelecaoCasa({ onSelecionarCasa }) {
  const [tempCasa, setTempCasa] = useState(null);

  const casas = [
    { id: 'AQUARIS', nome: 'Aquaris', elemento: 'Água', imagem: cardAquaris, dbId: 1, glow: 'hover:shadow-cyan-500/60 border-cyan-500/30', corTexto: 'text-cyan-400' },
    { id: 'IGNIS', nome: 'Ignis', elemento: 'Fogo', imagem: cardIgnis, dbId: 2, glow: 'hover:shadow-orange-600/60 border-orange-600/30', corTexto: 'text-orange-500' },
    { id: 'VENTUS', nome: 'Ventus', elemento: 'Ar', imagem: cardVentus, dbId: 3, glow: 'hover:shadow-emerald-400/60 border-emerald-400/30', corTexto: 'text-emerald-400' },
    { id: 'TERRAE', nome: 'Terrae', elemento: 'Terra', imagem: cardTerrae, dbId: 4, glow: 'hover:shadow-amber-800/60 border-amber-800/30', corTexto: 'text-amber-600' },
  ];

  return (
    <div 
      className="relative min-h-screen bg-cover bg-center bg-no-repeat flex flex-col items-center justify-center p-4 md:p-8 overflow-x-hidden select-none"
      style={{ backgroundImage: `url(${bgCastle})` }}
    >
      <div className="absolute inset-0 bg-black/70 backdrop-blur-[2px] z-0"></div>

      <div className="relative z-10 w-full max-w-7xl flex flex-col items-center">
        
        <header className="text-center mb-10 md:mb-14 max-w-2xl">
          <h1 className="text-4xl md:text-6xl font-extrabold tracking-[0.2em] text-transparent bg-clip-text bg-gradient-to-b from-amber-200 to-amber-500 font-serif drop-shadow-[0_5px_5px_rgba(0,0,0,0.8)]">
            ARCANE ARCHIVE
          </h1>
          <div className="w-32 h-[2px] bg-gradient-to-r from-transparent via-amber-400 to-transparent mx-auto my-3"></div>
          <p className="text-sm md:text-lg text-slate-300 font-medium tracking-widest uppercase italic">
            Descubra sua essência. Defenda seu legado.
          </p>
        </header>

        <main className="grid grid-cols-1 sm:grid-cols-2 lg:grid-cols-4 gap-6 md:gap-8 w-full px-4">
          {casas.map((casa) => (
            <div
              key={casa.id}
              onClick={() => setTempCasa(casa)}
              className={`group relative cursor-pointer rounded-2xl border bg-slate-950/40 backdrop-blur-sm overflow-hidden transform transition-all duration-500 hover:-translate-y-4 shadow-[0_10px_30px_rgba(0,0,0,0.5)] ${casa.glow} ${
                tempCasa?.id === casa.id ? 'ring-4 ring-amber-400 scale-105 shadow-[0_0_40px_rgba(245,158,11,0.4)]' : ''
              }`}
            >
              <img src={casa.imagem} alt={`Carta ${casa.nome}`} className="w-full max-w-[260px] mx-auto h-auto object-cover opacity-90 group-hover:opacity-100 transition-opacity duration-300" />
              <div className="absolute inset-0 bg-gradient-to-tr from-transparent via-white/10 to-transparent -translate-x-full group-hover:translate-x-full transition-transform duration-1000 ease-out"></div>
            </div>
          ))}
        </main>

        <footer className="h-32 mt-12 w-full flex items-center justify-center z-20">
          {tempCasa ? (
            <div className="bg-slate-950/90 border border-amber-500/30 px-8 py-4 rounded-xl text-center max-w-xl shadow-2xl backdrop-blur-md">
              <p className="text-slate-300 text-sm md:text-base tracking-wide">
                O portal reconheceu sua afinidade com a linhagem de <span className={`${tempCasa.corTexto} font-bold uppercase`}>{tempCasa.elemento}</span>.
              </p>
              <button 
                onClick={() => onSelecionarCasa(tempCasa)}
                className="mt-4 inline-block bg-gradient-to-r from-amber-600 to-amber-500 hover:from-amber-500 hover:to-amber-400 text-slate-950 font-bold uppercase text-xs tracking-widest py-3 px-8 rounded-md shadow-lg transition-all transform active:scale-95 cursor-pointer border-none"
              >
                Adentrar a Casa {tempCasa.nome}
              </button>
           </div>
         ) : (
           <p className="text-slate-400 text-sm tracking-widest uppercase animate-pulse italic text-center px-4">
             Aproxime-se e selecione uma das quatro insígnias elementares para iniciar...
           </p>
        )}
       </footer>
      </div>
    </div>
  );
}