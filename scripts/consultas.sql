
SET search_path TO bd2,
                   public;

-- lista objetos de arte comprados por tipo e por classe (emprestado ou proprio)

select oa.numId as id_objeto,
       oa.titulo,
       oa.tipoObjArt as tipo,
       coalesce(cast(e.numObj4 as varchar), 'PERMANENTE-') || coalesce(cast(pe.numObj5 as varchar), '-EMPRESTADO') as classe
from objetos_arte oa
full join emprestados e on e.numObj4 = oa.numId
full join permanentes pe on pe.numObj5 = oa.numId;

-- melhorada

select oa.numId as id_objeto,
       oa.titulo,
       oa.tipoObjArt as tipo,
       CASE
           WHEN e.numObj4 IS NULL then 'PERMANENTE'
           WHEN pe.numObj5 IS NULL then 'EMPRESTADO'
       END as classe
from objetos_arte oa
full join emprestados e on e.numObj4 = oa.numId
full join permanentes pe on pe.numObj5 = oa.numId;

-- liste as colecoes com o maior numero de emprestimos por mes e por ano
 --listagem da quantidade de objetos emprestados por colecao, por mes e por ano (nao finalizada f)

select co.nomeCol,
       count(e.numObj4) as qtd_obj_emprestados
from colecao co
join emprestados e on e.nomeColPert = co.nomeCol
group by co.nomeCol
order by count(e.numObj4) desc;

