import './../styles/Modal.css';

function Modal({ isOpen, onClose, children }) {

  function closeModal() {
    onClose();
  }

  if (!isOpen) {
    return null;
  }

  return (
    <div class="modal">
      <div class="close-modal" onClick={closeModal}>❌</div>
      {children}
    </div>
  )

}

export default Modal;
