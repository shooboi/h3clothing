package net.aptech.h3clothing.service.serviceImpl;

import net.aptech.h3clothing.dto.SizeDTO;
import net.aptech.h3clothing.entity.Size;
import net.aptech.h3clothing.repository.SizeRepository;
import net.aptech.h3clothing.service.GenericService;
import net.aptech.h3clothing.util.Utility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class SizeServiceImpl implements GenericService<SizeDTO> {
    @Autowired
    SizeRepository sizeRepository;

    @Autowired
    Utility utility;

    @Override
    public List<SizeDTO> getAll() {
        return utility.convertSizeDTOFromSizes(sizeRepository.findAll());
    }

    @Override
    public SizeDTO save(SizeDTO sizeDTO) {
        Size s = sizeRepository.save(utility.convertSizeFromSizeDTO(sizeDTO));
        return new SizeDTO(s.getName(),s.getQuantity());
    }

    @Override
    public Optional<SizeDTO> getById(int id) {
        return Optional.of(utility.convertSizeDTOFromSize(sizeRepository.getById(id)));
    }

    @Override
    public void remove(int id) {
        sizeRepository.deleteById(id);
    }
}
