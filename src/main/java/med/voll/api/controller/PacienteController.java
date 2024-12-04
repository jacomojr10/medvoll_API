package med.voll.api.controller;

import med.voll.api.domain.dto.DadosCadastroPaciente;
import med.voll.api.domain.dto.DadosListagemPaciente;
import med.voll.api.domain.paciente.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/paciente")
public class PacienteController {

    @Autowired
    private PacienteRepository pacienteRepository;

    @PostMapping
    public void cadastrarPaciente(@RequestBody DadosCadastroPaciente dadosPaciente){
        System.out.println("dados recebido: " + dadosPaciente);
    }

    @GetMapping
    public Page<DadosListagemPaciente> listagemPacientes(@PageableDefault(size = 10, sort = {"nome"})Pageable paginacao){
        return pacienteRepository.findAll(paginacao).map(DadosListagemPaciente::new);
    }

}
