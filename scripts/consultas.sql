SET search_path TO bd2, public;

-- 1 lista objetos de arte comprados por tipo e por classe (emprestado ou proprio)
select oa.numId as id_objeto, oa.titulo, oa.tipoObjArt as tipo, 
coalesce(cast(e.numObj4 as varchar), 'PERMANENTE-') ||
coalesce(cast(pe.numObj5 as varchar), '-EMPRESTADO') as classe
from objetos_arte oa
full join emprestados e on e.numObj4 = oa.numId
full join permanentes pe on pe.numObj5 = oa.numId;
-- melhorada
select oa.numId as id_objeto, oa.titulo, oa.tipoObjArt as tipo, 
CASE
	WHEN e.numObj4 IS NULL then 'PERMANENTE'
	WHEN pe.numObj5 IS NULL then 'EMPRESTADO'
	ELSE 'OUTROS'
END as classe
from objetos_arte oa
full join emprestados e on e.numObj4 = oa.numId
full join permanentes pe on pe.numObj5 = oa.numId;


-- 2. liste as colecoes com o maior numero de emprestimos por mes e por ano (maior quantidade de objetos emprestados?)

-- 3. listagem da compra de objetos de arte por mes e por ano
select CAST(SUM(pe.custo) as money) as custo_total,
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
group by EXTRACT(month from pe.dataaquisicao), ano
order by EXTRACT(month from pe.dataaquisicao), ano;

-- simplificada skdksdks
select CAST(SUM(pe.custo) as money) as custo_total, EXTRACT(month from pe.dataaquisicao) as mes,
EXTRACT(year from pe.dataaquisicao) as ano
from permanentes pe
group by mes, ano 
order by mes, ano;

-- 4. listagem da quantidade de objetos emprestados por colecao, por mes e por ano (nao finalizada f)
select co.nomeCol, count(e.numObj4) as qtd_obj_emprestados,
EXTRACT(month from e.dataemprestimo) as mes,
EXTRACT(year from e.dataemprestimo) as ano
from colecao co
join emprestados e on e.nomeColPert = co.nomeCol
group by co.nomeCol, mes, ano
order by mes, ano;