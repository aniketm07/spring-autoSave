package com.autosavejs.AutoSave.repository;

import com.autosavejs.AutoSave.entity.UserText;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserTextRepository extends JpaRepository<UserText, String> {
}
