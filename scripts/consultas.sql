SET search_path TO bd2, public;

-- 1 lista objetos de arte comprados por tipo e por classe (emprestado ou proprio)
select oa.numId as id_objeto, oa.titulo, oa.tipoObjArt as tipo, 
CASE
	WHEN e.numObj4 IS NULL then 'PERMANENTE'
	WHEN pe.numObj5 IS NULL then 'EMPRESTADO'
	ELSE 'OUTROS'
END as classe
from objetosarte oa
full join emprestados e on e.numObj4 = oa.numId
full join permanentes pe on pe.numObj5 = oa.numId;


-- 2. liste as colecoes com o maior numero de emprestimos por mes e por ano (maior quantidade de objetos emprestados?)
select count(e.numObj4) as qtd_total_objetos, co.nomecol from colecao co
join emprestados e on e.nomecolpert = co.nomecol
group by co.nomecol
order by qtd_total_objetos desc;

-- 3. listagem da compra de objetos de arte por mes e por ano
select CAST(SUM(oa.custo) as money) as custo_total, EXTRACT(month from pe.dataaquisicao) as numMes,
CASE
	WHEN EXTRACT(month from pe.dataaquisicao) = 1 THEN 'JANEIRO'
	WHEN EXTRACT(month from pe.dataaquisicao) = 2 THEN 'FEVEREIRO'
	WHEN EXTRACT(month from pe.dataaquisicao) = 3 THEN 'MARÇO'
	WHEN EXTRACT(month from pe.dataaquisicao) = 4 THEN 'ABRIL'
	WHEN EXTRACT(month from pe.dataaquisicao) = 5 THEN 'MAIO'
	WHEN EXTRACT(month from pe.dataaquisicao) = 6 THEN 'JUNHO'
	WHEN EXTRACT(month from pe.dataaquisicao) = 7 THEN 'JULHO'
	WHEN EXTRACT(month from pe.dataaquisicao) = 8 THEN 'AGOSTO'
	WHEN EXTRACT(month from pe.dataaquisicao) = 9 THEN 'SETEMBRO'
	WHEN EXTRACT(month from pe.dataaquisicao) = 10 THEN 'OUTUBRO'
	WHEN EXTRACT(month from pe.dataaquisicao) = 11 THEN 'NOVEMBRO'
	WHEN EXTRACT(month from pe.dataaquisicao) = 12 THEN 'DEZEMBRO'
END as mes,
EXTRACT(year from pe.dataaquisicao) as ano
from permanentes pe
inner join objetos_arte oa on oa.numid = pe.numobj5
group by numMes, ano
order by numMes, ano;

-- simplificada
select CAST(SUM(pe.custo) as money) as custo_total, EXTRACT(month from pe.dataaquisicao) as mes,
EXTRACT(year from pe.dataaquisicao) as ano
from permanentes pe
group by mes, ano 
order by mes, ano;

-- 4. listagem da quantidade de objetos emprestados por colecao, por mes e por ano (nao finalizada f)
select co.nomeCol, count(e.numObj4) as qtd_obj_emprestados,
EXTRACT(month from e.dataemprestimo) as nummes,
CASE
	WHEN EXTRACT(month from e.dataemprestimo) = 1 THEN 'JANEIRO'
	WHEN EXTRACT(month from e.dataemprestimo) = 2 THEN 'FEVEREIRO'
	WHEN EXTRACT(month from e.dataemprestimo) = 3 THEN 'MARÇO'
	WHEN EXTRACT(month from e.dataemprestimo) = 4 THEN 'ABRIL'
	WHEN EXTRACT(month from e.dataemprestimo) = 5 THEN 'MAIO'
	WHEN EXTRACT(month from e.dataemprestimo) = 6 THEN 'JUNHO'
	WHEN EXTRACT(month from e.dataemprestimo) = 7 THEN 'JULHO'
	WHEN EXTRACT(month from e.dataemprestimo) = 8 THEN 'AGOSTO'
	WHEN EXTRACT(month from e.dataemprestimo) = 9 THEN 'SETEMBRO'
	WHEN EXTRACT(month from e.dataemprestimo) = 10 THEN 'OUTUBRO'
	WHEN EXTRACT(month from e.dataemprestimo) = 11 THEN 'NOVEMBRO'
	WHEN EXTRACT(month from e.dataemprestimo) = 12 THEN 'DEZEMBRO'
END as mes,
EXTRACT(year from e.dataemprestimo) as ano
from colecao co
join emprestados e on e.nomeColPert = co.nomeCol
group by co.nomeCol, nummes, ano
order by nummes, ano;

-- CONSULTAS COMPLEMENTARES-----------------------------------
-- complementar à 2--
select *
from permanentes pe
WHERE EXTRACT(month from pe.dataaquisicao) = 5 and
EXTRACT(year from pe.dataaquisicao) = 1977;
