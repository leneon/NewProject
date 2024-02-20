package com.example.project.services;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;


import com.example.project.entities.Client;
import com.example.project.repositories.ClientRepository;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

@Service
public class ClientService {

    private final ClientRepository clientRepository;

    @Autowired
    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    public Client getClientById(Long id) {
        return clientRepository.findById(id).orElse(null);
    }

    public Client createClient(Client client) {
        return clientRepository.save(client);
    }

    public Client updateClient(Long id, Client client) {
        if (clientRepository.existsById(id)) {
            client.setId(id);
            return clientRepository.save(client);
        }
        return null;
    }

    public void deleteClient(Long id) {
        clientRepository.deleteById(id);
    }

public void importClientsFromExcel(MultipartFile file) throws IOException, BiffException {
        Workbook workbook = Workbook.getWorkbook(file.getInputStream());
        Sheet sheet = workbook.getSheet(0);

        for (int i = 0; i < sheet.getRows(); i++) {
            Cell[] row = sheet.getRow(i);
            // Créer un objet Client à partir des données de la ligne et l'enregistrer dans la base de données
            Client client = new Client();
            client.setNumeroOp(row[0].getContents());
            client.setBanque(row[1].getContents());
            client.setZone(row[2].getContents());
            client.setLocalite(row[3].getContents());
            client.setAgence(row[4].getContents());
            client.setCaisse(row[5].getContents());
            client.setDatecreation(new Date(row[6].getContents()));
            clientRepository.save(client);
        }

        workbook.close();
    }
    
}
